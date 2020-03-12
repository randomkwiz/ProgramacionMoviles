// Generated code from Butter Knife. Do not modify!
package es.iesnervion.avazquez.puntokusapp.activities;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import es.iesnervion.avazquez.puntokusapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SecondMainActivity_ViewBinding implements Unbinder {
  private SecondMainActivity target;

  @UiThread
  public SecondMainActivity_ViewBinding(SecondMainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SecondMainActivity_ViewBinding(SecondMainActivity target, View source) {
    this.target = target;

    target.bottomNavigationView = Utils.findRequiredViewAsType(source, R.id.menu_nav_bottom, "field 'bottomNavigationView'", BottomNavigationView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SecondMainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.bottomNavigationView = null;
  }
}
