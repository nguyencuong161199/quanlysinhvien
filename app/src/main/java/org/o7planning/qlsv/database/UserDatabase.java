package org.o7planning.qlsv.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.o7planning.qlsv.user;
//
@Database(entities = {user.class},version = 2)

public abstract class UserDatabase extends RoomDatabase {

    static Migration migration_from_1_to_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE user ADD COLUMN GRADE TEXT");
            database.execSQL("ALTER TABLE user ADD COLUMN SEX TEXT");
            database.execSQL("ALTER TABLE user ADD COLUMN MATH TEXT");
            database.execSQL("ALTER TABLE user ADD COLUMN PHYSICAL TEXT");
            database.execSQL("ALTER TABLE user ADD COLUMN CHEMISTRY TEXT");

        }
    };
    private static final String DATABASE_NAME = "user.db";
    private static UserDatabase instance;

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .addMigrations(migration_from_1_to_2)
                    .build();
        }
        return instance;

    }
    public abstract userDAO userDAO();
}

