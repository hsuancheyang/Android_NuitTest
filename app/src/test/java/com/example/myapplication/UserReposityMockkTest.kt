package com.example.myapplication

import com.example.myapplication.user.User
import com.example.myapplication.user.UserRepository
import com.example.myapplication.user.UserService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class UserRepositoryMockkTest {
    private val userService = mockk<UserService>()
    private val repository = UserRepository(userService)

    @Test
    fun test_ReturnFirstUser() = runBlocking {
        val users = listOf(User(1, "Alice", "alice@gmail.com"))
        coEvery { userService.getUsers() } returns users
        val result = repository.fetchFirstUserName()
        Assert.assertEquals("First user: Alice", result)
    }

    @Test
    fun test_ReturnEmptyUser() = runBlocking {
        coEvery { userService.getUsers() } returns emptyList()
        val result = repository.fetchFirstUserName()
        Assert.assertEquals("No users Found", result)
    }

    @Test
    fun test_ReturnNetworkError() = runBlocking {
        coEvery { userService.getUsers() } throws Exception("Network error")
        val result = repository.fetchFirstUserName()
        Assert.assertEquals("Error: Network error", result)
    }

}