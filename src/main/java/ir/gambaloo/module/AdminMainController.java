import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdminMainController {

    @FXML
    private Button add;

    @FXML
    private TableColumn<?, ?> country;

    @FXML
    private Button delete;

    @FXML
    private Button edit;

    @FXML
    private TableColumn<?, ?> restaurant;

    @FXML
    private TableView<?> tabel;

    @FXML
    private TableColumn<?, ?> type;

}
