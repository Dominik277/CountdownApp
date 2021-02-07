package countdown.app.Repository

import androidx.lifecycle.LiveData
import countdown.app.Data.UserDao
import countdown.app.Model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

}