package bo.edu.mvp2020

import android.content.Context

class LoginPresenter(val view: IContractLogin.View, val context: Context): IContractLogin.Presenter {
    override fun login(username: String, password: String) {
        view.showProgressBar()
        when {
            username.isEmpty() ->
                view.showError(context.getString(R.string.login_username_isempty))
            password.isEmpty() ->
                view.showErrorPassword(R.string.login_password_is_empty)
            else ->  {
                view.hideProgressBar()
                view.showSuccessful(context.getString(R.string.successful))
                view.goToMain()
            }
        }

    }
}