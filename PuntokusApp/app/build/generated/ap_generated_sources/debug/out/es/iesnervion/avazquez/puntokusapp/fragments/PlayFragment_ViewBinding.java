// Generated code from Butter Knife. Do not modify!
package es.iesnervion.avazquez.puntokusapp.fragments;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import es.iesnervion.avazquez.puntokusapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlayFragment_ViewBinding implements Unbinder {
  private PlayFragment target;

  @UiThread
  public PlayFragment_ViewBinding(PlayFragment target, View source) {
    this.target = target;

    target.easyBtn = Utils.findRequiredViewAsType(source, R.id.view1, "field 'easyBtn'", Button.class);
    target.normalBtn = Utils.findRequiredViewAsType(source, R.id.view2, "field 'normalBtn'", Button.class);
    target.hardBtn = Utils.findRequiredViewAsType(source, R.id.view3, "field 'hardBtn'", Button.class);
    target.sickBtn = Utils.findRequiredViewAsType(source, R.id.view4, "field 'sickBtn'", Button.class);
    target.infoBtn = Utils.findRequiredViewAsType(source, R.id.infobtn, "field 'infoBtn'", FloatingActionButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlayFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.easyBtn = null;
    target.normalBtn = null;
    target.hardBtn = null;
    target.sickBtn = null;
    target.infoBtn = null;
  }
}
