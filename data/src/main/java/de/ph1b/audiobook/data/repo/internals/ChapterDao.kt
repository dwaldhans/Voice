package de.ph1b.audiobook.data.repo.internals

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import de.ph1b.audiobook.data.Chapter
import java.util.UUID

@Dao
interface ChapterDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(chapters: List<Chapter>)

  @Query("SELECT * FROM chapters WHERE bookId = :bookId")
  fun byBookId(bookId: UUID): List<Chapter>

  @Query("DELETE FROM chapters WHERE bookId = :bookId")
  fun deleteByBookId(bookId: UUID)
}
