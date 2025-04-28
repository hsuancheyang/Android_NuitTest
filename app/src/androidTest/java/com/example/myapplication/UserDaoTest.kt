package com.example.myapplication

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.myapplication.user.AppDatabase
import com.example.myapplication.user.User
import com.example.myapplication.user.UserDao
import kotlinx.coroutines.runBlocking
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class UserDaoTest {
    companion object {
        private lateinit var db: AppDatabase
        private lateinit var userDao: UserDao

        @JvmStatic
        @BeforeClass
        fun createDB() {
            val context = ApplicationProvider.getApplicationContext<Context>()
            db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()
            userDao = db.userDAO()
        }

        @JvmStatic
        @AfterClass
        fun closeDB(){
            db.close()
        }

        @Before
        fun clear() = runBlocking {
            userDao.deleteAll()
        }

        @Test
        fun insert() = runBlocking {
            val user = User(name = "Bill", email = "bill@gmail.com")

        }
    }
}