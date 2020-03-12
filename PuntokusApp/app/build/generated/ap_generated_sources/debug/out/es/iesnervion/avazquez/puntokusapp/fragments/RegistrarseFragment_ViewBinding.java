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

public class RegistrarseFragment_ViewBinding implements Unbinder {
  private RegistrarseFragment target;

  @UiThread
  public RegistrarseFragment_ViewBinding(RegistrarseFragment target, View source) {
    this.target = target;

    target.email = Utils.findRequiredViewAsType(source, R.id.input_email, "field 'email'", EditText.class);
    target.nickname = Utils.findRequiredViewAsType(source, R.id.input_nickname, "field 'nickname'", EditText.class);
    target.password = Utils.findRequiredViewAsType(source, R.id.input_password, "field 'password'", EditText.class);
    target.btnSignup = Utils.findRequiredViewAsType(source, R.id.btn_signup, "field 'btnSignup'", Button.class);
    target.linkLogin = Utils.findRequiredViewAsType(source, R.id.link_login, "field 'linkLogin'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegistrarseFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.email = null;
    target.nickname = null;
    target.password = null;
    target.btnSignup = null;
    target.linkLogin = null;
  }
}
