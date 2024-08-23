package RoomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val id:String,
    @ColumnInfo
    val title:String,
    @ColumnInfo
    val description:String,
    @ColumnInfo(index = true)
    val date:Long,
    @ColumnInfo
    val time:Long,
    @ColumnInfo
    val status:Boolean=false
)
