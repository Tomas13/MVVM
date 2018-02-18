package ru.startandroid.mvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

public class MainViewModel extends ViewModel{

    private LiveData<User> user;
    private UserRepository userRepo;
    private final SnackbarMessage mSnackbarText = new SnackbarMessage();
    public final ObservableBoolean dataLoading = new ObservableBoolean(false);

    public LiveData<Boolean> ready = new MutableLiveData<>();

    public MainViewModel() {
        this.userRepo = new UserRepository();
    }

    public void init(String userId) {
//        if (this.user != null) {
//            // ViewModel is created per Fragment so
//            // we know the userId won't change
//            return;
//        }
        dataLoading.set(true);

        user = userRepo.getUser(userId);
        showSnackbarMessage(R.string.task_marked_complete);

        dataLoading.set(false);

    }

    SnackbarMessage getSnackbarMessage() {
        return mSnackbarText;
    }

    public LiveData<User> getUser() {
        showSnackbarMessage(R.string.getuser);

        return user;
    }


    private void showSnackbarMessage(Integer message) {
        mSnackbarText.setValue(message);
    }

}
