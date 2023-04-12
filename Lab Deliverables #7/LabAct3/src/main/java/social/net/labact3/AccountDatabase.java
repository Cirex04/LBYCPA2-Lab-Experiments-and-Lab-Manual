package social.net.labact3;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @brief Data Structure to hold data in the database
 */

public class AccountDatabase {
    /**
     * properties
     */
    private LinkedList<AccountRecord> records;

    /**
     * constructors
     */
    public AccountDatabase() {
        records = new LinkedList<>();
    }

    /**
     * behaviors
     */
    public void accountConnect(String loggedIn) throws IOException {
        FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\" +
                "main\\" +
                "resources\\" +
                "social\\" +
                "net\\" +
                "labact3\\" +
                "database\\" +
                "master_account_list\\" +
                loggedIn + "\\" +
                "myAccount.csv");
        Scanner scanner = new Scanner(file);

        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            AccountRecord record = new AccountRecord(line[0], line[1], line[2], line[3]);
            records.add(record);
        }

        scanner.close();
        file.close();
    }

    public LinkedList<AccountRecord> getRecords() {
        return records;
    }
}
