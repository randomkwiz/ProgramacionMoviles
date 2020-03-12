// Generated code from Butter Knife. Do not modify!
package es.iesnervion.avazquez.puntokusapp.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import es.iesnervion.avazquez.puntokusapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AccountFragment_ViewBinding implements Unbinder {
  private AccountFragment target;

  @UiThread
  public AccountFragment_ViewBinding(AccountFragment target, View source) {
    this.target = target;

    target.nickname = Utils.findRequiredViewAsType(source, R.id.txtNickname_account, "field 'nickname'", TextView.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.txtEmail_account, "field 'email'", TextView.class);
    target.btnLogout = Utils.findRequiredViewAsType(source, R.id.btn_logout, "field 'btnLogout'", Button.class);
    target.sounds = Utils.findRequiredViewAsType(source, R.id.toggleSounds, "field 'sounds'", Switch.class);
    target.music = Utils.findRequiredViewAsType(source, R.id.toggleMusic, "field 'music'", Switch.class);
    target.btn_delete = Utils.findRequiredViewAsType(source, R.id.btn_delete, "field 'btn_delete'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AccountFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nickname = null;
    target.email = null;
    target.btnLogout = null;
    target.sounds = null;
    target.music = null;
    target.btn_delete = null;
  }
}
