package org.o7planning.qlsv.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.o7planning.qlsv.user;

import java.util.List;

@Dao
public interface userDAO {

    @Insert
    void insertUser(user user);
    @Query("SELECT * from user")
    List<user> getListUser();

}
