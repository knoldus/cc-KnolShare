package com.knoldus.dao.components

import com.knoldus.dao.connection.TestDBHelper
import com.knoldus.models.User
import play.api.test.PlaySpecification

class UserComponentSpec extends PlaySpecification with UserComponent with TestDBHelper {

  sequential
  "User Component" should {

    "be able to create new user" in {
      val user = await(createUser(User(2, "userName", "userEmail", "password")))
      user.id must be equalTo (2)
    }

    "be able to update user" in {
      val updateCount = await(updateUserById(1, User(1, "newUser", "email", "passw")))
      updateCount must beEqualTo(1)
    }

    "be able to delete user" in {
      val deleteCount = await(deleteUserById(1))
      deleteCount must beEqualTo(1)
    }

    "be able to get user by id" in {
      val user: Option[User] = await(getUserById(1))
      user.get.id must beEqualTo(1)
      user.get.userName must beEqualTo("sangeeta")
    }
  }

}