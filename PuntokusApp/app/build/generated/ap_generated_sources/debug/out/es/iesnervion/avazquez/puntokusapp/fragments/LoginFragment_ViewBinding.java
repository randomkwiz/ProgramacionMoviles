// Generated code from Butter Knife. Do not modify!
package es.iesnervion.avazquez.puntokusapp.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import es.iesnervion.avazquez.puntokusapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginFragment_ViewBinding implements Unbinder {
  private LoginFragment target;

  @UiThread
  public LoginFragment_ViewBinding(LoginFragment target, View source) {
    this.target = target;

    target.email = Utils.findRequiredViewAsType(source, R.id.input_email, "field 'email'", EditText.class);
    target.password = Utils.findRequiredViewAsType(source, R.id.input_password, "field 'password'", EditText.class);
    target.btnLogin = Utils.findRequiredViewAsType(source, R.id.btn_login, "field 'btnLogin'", Button.class);
    target.linkSignUp = Utils.findRequiredViewAsType(source, R.id.link_signup, "field 'linkSignUp'", TextView.class);
    target.rememberPassword = Utils.findRequiredViewAsType(source, R.id.rememberPassword, "field 'rememberPassword'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.email = null;
    target.password = null;
    target.btnLogin = null;
    target.linkSignUp = null;
    target.rememberPassword = null;
  }
}
