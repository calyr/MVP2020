package bo.edu.mvp2020

interface IContractLogin {
    interface View {
        fun showError(message: String)
        fun showSuccessful(message: String)
        fun showErrorPassword(message: Int)
        fun goToMain()
        fun hideProgressBar()
        fun showProgressBar()
    }

    interface Presenter {
        fun login(username: String, password: String)
    }
}