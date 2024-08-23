package RoomDatabase

import RoomDatabase.Dao.TaskDao
import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [Task::class], version = 0, exportSchema = true)
abstract class AppDatabase: RoomDatabase()
{
    abstract fun taskDao():TaskDao
}