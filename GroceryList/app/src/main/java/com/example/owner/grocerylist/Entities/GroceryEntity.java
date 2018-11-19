package com.example.owner.grocerylist.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Objects;

@Entity(tableName = "grocery_table")
public class GroceryEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "_id")
    private int _id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "quantity")
    private String quantity;

    @NonNull
    @ColumnInfo(name = "notes")
    private String notes;

    @NonNull
    @ColumnInfo(name = "filepath")
    private String filepath;

    public GroceryEntity(@NonNull String name, @NonNull String quantity, @NonNull String notes, @NonNull String filepath) {
        this.name = name;
        this.quantity = quantity;
        this.notes = notes;
        this.filepath = filepath;
    }

    @NonNull
    public int get_id() {
        return _id;
    }

    public void set_id(@NonNull int _id) {
        this._id = _id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(@NonNull String quantity) {
        this.quantity = quantity;
    }

    @NonNull
    public String getNotes() {
        return notes;
    }

    public void setNotes(@NonNull String notes) {
        this.notes = notes;
    }

    @NonNull
    public String getFilepath() { return filepath; }

    public void setFilepath(@NonNull String filepath) { this.filepath = filepath; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroceryEntity)) return false;
        GroceryEntity that = (GroceryEntity) o;
        return get_id() == that.get_id() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getQuantity(), that.getQuantity()) &&
                Objects.equals(getNotes(), that.getNotes());
    }

    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getName(), getQuantity(), getNotes());
    }

    @Override
    public String toString() {
        return "GroceryEntity{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", notes='" + notes + '\'' +
                ", filepath='" + filepath + '\''+
                '}';
    }
}
