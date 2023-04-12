package social.net.labact3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Objects;

public class Controller {
    private FriendDatabase totalAccountFriends;
    private AccountDatabase accountDataLogs;

    @FXML
    private TextField nameField;
    @FXML
    private Label statusProf;
    @FXML
    private Label statusLabel;
    @FXML
    private Label name;
    @FXML
    private Label favQuote;
    @FXML
    private TextField statusChangeLabel;
    @FXML
    private TextField unfriendLabel;
    @FXML
    private TextField quoteLabel;
    @FXML
    private ImageView pictureView;
    @FXML
    private ListView listView;
    @FXML
    private ObservableList<String> friendList;

    @FXML
    private void initialize() throws URISyntaxException, IOException {
        friendList = FXCollections.observableArrayList();
        listView.setItems(friendList);
        accountDataLogs = new AccountDatabase();
        totalAccountFriends = new FriendDatabase();
        lookup("melvin cabatuan");
    }

    private String formalize(String informal) {
        StringBuilder informalBuilder = new StringBuilder();
        informalBuilder.append(Character.toUpperCase(informal.charAt(0)));
        for (int i = 1; i < informal.length(); i++) {
            if (informal.charAt(i) == ' ') {
                informalBuilder.append(informal.charAt(i));
                informalBuilder.append(Character.toUpperCase(informal.charAt(++i)));
            } else
                informalBuilder.append(informal.charAt(i));
        }

        return informalBuilder.toString();
    }

    private void lookup(String friend) throws URISyntaxException, IOException {
        friend = formalize(friend);
        name.setText(friend);
        accountDataLogs.accountConnect(friend);
        totalAccountFriends.accountConnection(friend);
        String profile_pic = Objects.requireNonNull(Main.class.getResource("images/" +
                accountDataLogs.getRecords().get(read_current_loggedIn()).Name() + "/" +
                accountDataLogs.getRecords().get(read_current_loggedIn()).ImageLocation())).toURI().toString();

        pictureView.setImage(new Image(profile_pic));
        favQuote.setText(accountDataLogs.getRecords().get(read_current_loggedIn()).FavoriteQuote());
        statusProf.setText(accountDataLogs.getRecords().get(read_current_loggedIn()).Status());

        ObservableList<String> obs = FXCollections.observableList(totalAccountFriends.getFriends_graph().getKey(accountDataLogs.getRecords().get(read_current_loggedIn()).Name()));
        listView.setItems(obs);
        totalAccountFriends.getFriends_graph().displayGraph();
    }

    private int read_current_loggedIn() {
        for (int i = 0; i < accountDataLogs.getRecords().size(); i++) {
            if (Objects.equals(accountDataLogs.getRecords().get(i).Name().toLowerCase(), name.getText().toLowerCase()))
                return i;
        }

        return 0;
    }

    private boolean isAccountPresent(String findName) {
        boolean found = false;

        File accounts = new File(System.getProperty("user.dir") + "\\src\\" +
                "main\\" +
                "resources\\" +
                "social\\" +
                "net\\" +
                "labact3\\" +
                "database\\" +
                "master_account_list");
        File[] folders = accounts.listFiles();
        ArrayList<String> registeredAccounts = new ArrayList<>();
        assert folders != null;
        for (File account : folders) {
            if (account.isDirectory())
                registeredAccounts.add(account.getName());
        }

        for (String registeredAccount : registeredAccounts) {
            if (Objects.equals(registeredAccount.toLowerCase(), findName.toLowerCase())) {
                found = true;
                break;
            }
        }

        return found;
    }

    private void removeFriend(String name) throws IOException {
        String loggedIn = accountDataLogs.getRecords().get(read_current_loggedIn()).Name();
        String[] friends = new String[totalAccountFriends.getFriends_graph().getKey(loggedIn).size()];
        friends[0] = "Friend Name";
        for (int i = 1; i < friends.length; i++) {
            if (!Objects.equals(totalAccountFriends.getFriends_graph().getKey(loggedIn).get(i), name))
                friends[i] = totalAccountFriends.getFriends_graph().getKey(loggedIn).get(i);
        }

        FileWriter writer = new FileWriter(System.getProperty("user.dir") + "\\src\\" +
                "main\\" +
                "resources\\" +
                "social\\" +
                "net\\" +
                "labact3\\" +
                "database\\" +
                "friends_list\\" +
                loggedIn + "\\" +
                "friend_graph.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        for (int i = 0; i < friends.length; i++) {
            bufferedWriter.write(friends[i]);
            bufferedWriter.newLine();
        }


        bufferedWriter.close();
        writer.close();
    }

    public void handleAdd(ActionEvent actionEvent) throws URISyntaxException, IOException {
        if (!nameField.getText().trim().isEmpty()) {
            if (!totalAccountFriends.getFriends_graph().getKey(name.getText()).contains(nameField.getText())) {
                if (isAccountPresent(nameField.getText())) {
                    totalAccountFriends.getFriends_graph().getKey(name.getText()).add(nameField.getText());
                    ObservableList<String> obs = FXCollections.observableList(totalAccountFriends.getFriends_graph().getKey(name.getText()));
                    listView.setItems(obs);
                    statusLabel.setText(nameField.getText() + " added");
                    totalAccountFriends.getFriends_graph().displayGraph();

                    FileWriter writer = new FileWriter(System.getProperty("user.dir") + "\\src\\" +
                            "main\\" +
                            "resources\\" +
                            "social\\" +
                            "net\\" +
                            "labact3\\" +
                            "database\\" +
                            "friends_list\\" +
                            accountDataLogs.getRecords().get(read_current_loggedIn()).Name() + "\\" +
                            "friend_graph.csv", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);

                    bufferedWriter.write(nameField.getText());
                    bufferedWriter.newLine();

                    bufferedWriter.close();
                    writer.close();

                    nameField.clear();
                } else {
                    statusLabel.setText(nameField.getText() + " is not in the registered accounts");
                    nameField.clear();
                }
            } else {
                statusLabel.setText(nameField.getText() + " is already in the friend's list");
                nameField.clear();
            }
        } else
            statusLabel.setText("Empty textfield");
    }

    public void handleLookup(ActionEvent actionEvent) throws URISyntaxException, IOException {
        if (!nameField.getText().trim().isEmpty()) {
            if (isAccountPresent(nameField.getText())) {
                lookup(nameField.getText());
                statusLabel.setText(nameField.getText() + " lookup");
                nameField.clear();
            } else {
                statusLabel.setText("Account not found");
                nameField.clear();
            }
        }
    }

    public void handleStatus(ActionEvent actionEvent) {
        if (!statusChangeLabel.getText().trim().isEmpty()) {
            statusProf.setText(statusChangeLabel.getText());
        }
    }

    public void handlePicture(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            pictureView.setImage(image);
        }

        // Specify the path to the new directory
        String pathString = System.getProperty("user.dir") + "/src/" +
                "main/" +
                "resources/" +
                "social/" +
                "net/" +
                "labact3/" +
                "images/" +
                name.getText();

        System.out.println(pathString);

        // Create the folder using the mkdirs() method
        boolean success = new File(pathString).mkdir();
        if (success)
            System.out.println("Folder created successfully!");
        else
            System.err.println("Failed to create folder!");

        // Copy the image file to a directory
        assert selectedFile != null;
        try {
            Path source = new File(selectedFile.toString()).toPath();
            Path targetDir = new File(pathString).toPath();
            Files.copy(source, targetDir.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            statusLabel.setText("Profile Picture Changed!");
        } catch (NullPointerException ignore) {
            statusLabel.setText("Profile Picture Not Changed!");
        }
    }

    public void handleUnfriend(ActionEvent actionEvent) throws IOException {
        if (!unfriendLabel.getText().trim().isEmpty()) {
            totalAccountFriends.getFriends_graph().getKey(name.getText()).remove(unfriendLabel.getText());
            ObservableList obs = FXCollections.observableList(totalAccountFriends.getFriends_graph().getKey(name.getText()));
            listView.setItems(obs);
            statusLabel.setText(unfriendLabel.getText() + " removed as friend");
            totalAccountFriends.getFriends_graph().displayGraph();
            unfriendLabel.clear();
            removeFriend(unfriendLabel.getText());
        } else
            statusLabel.setText("Empty textfield");
    }

    public void handleQuote(ActionEvent actionEvent) {
        if (!quoteLabel.getText().trim().isEmpty()) {
            favQuote.setText(quoteLabel.getText());
            statusLabel.setText("Quote changed to " + quoteLabel.getText());
        } else
            statusLabel.setText("Empty textfield");
    }
}
