package bo.edu.mvp2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), IContractLogin.View {
    lateinit var presenter: IContractLogin.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this, applicationContext)

        loginBtn.setOnClickListener {
            presenter.login(usernameEdtiText.text.toString(), passwordEditText.text.toString() )
        }

    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showSuccessful(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showErrorPassword(message: Int) {
        passwordEditText.error = getString(message)
    }

    override fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun hideProgressBar() {
        progressBarLogin.visibility = View.GONE
    }

    override fun showProgressBar() {
        progressBarLogin.visibility = View.VISIBLE
    }
}