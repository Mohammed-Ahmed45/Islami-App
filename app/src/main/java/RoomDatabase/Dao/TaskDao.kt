package RoomDatabase.Dao

import RoomDatabase.Task
import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TaskDao
{
    @Insert
    fun creatTask(task: Task)

}