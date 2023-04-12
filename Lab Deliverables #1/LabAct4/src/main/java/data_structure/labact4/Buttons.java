package data_structure.labact4;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface Buttons {
    void exit_prog(ActionEvent event);

    void main_view(ActionEvent event) throws IOException;

    void static_array(ActionEvent event) throws IOException;

    void dynamic_array(ActionEvent event) throws IOException;

    void singly_linked_list(ActionEvent event) throws IOException;

    void doubly_linked_list(ActionEvent event) throws IOException;

    void stack(ActionEvent event) throws IOException;

    void queue(ActionEvent event) throws IOException;

    void binary_search_tree(ActionEvent event) throws IOException;

    void hash_table(ActionEvent event) throws IOException;
}
