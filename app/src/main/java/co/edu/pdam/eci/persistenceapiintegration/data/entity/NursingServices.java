package co.edu.pdam.eci.persistenceapiintegration.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by 2101751 on 4/24/18.
 */

@DatabaseTable
public class NursingServices extends BaseEntity {

    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "description")
    private String description;
    @DatabaseField(columnName = "image")
    private String image;

    public NursingServices() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
