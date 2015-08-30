package alexiuscrow.epl.view;

import alexiuscrow.epl.domain.Participant;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * Created by Alexiuscrow on 30.08.2015.
 */
public class ParticipantListCell extends ListCell<Participant> {
    private ImageView avatar;
    private Label fullName;
    private Hyperlink pageLink;
    private String status;

    @Override
    public void updateItem(Participant item, boolean empty) {
        super.updateItem(item, empty);

        if (empty)
            return;

        //Grid pane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(4);
        grid.setPadding(new Insets(0, 10, 0, 10));

        //
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }

    public Label getFullName() {
        return fullName;
    }

    public void setFullName(Label fullName) {
        this.fullName = fullName;
    }

    public Hyperlink getPageLink() {
        return pageLink;
    }

    public void setPageLink(Hyperlink pageLink) {
        this.pageLink = pageLink;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
