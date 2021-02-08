package countdown.app.di

import android.app.Application
import androidx.room.Room
import countdown.app.data.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        app: Application
    ) = Room.databaseBuilder(app,TaskDatabase::class.java,"task_database")
                .fallbackToDestructiveMigration()
                .addCallback()
                .build()

    @Provides
    fun provideTaskDao(db: TaskDatabase) = db.taskDao()
}