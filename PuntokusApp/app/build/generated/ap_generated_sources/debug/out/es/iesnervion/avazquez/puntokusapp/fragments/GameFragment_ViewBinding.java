// Generated code from Butter Knife. Do not modify!
package es.iesnervion.avazquez.puntokusapp.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import es.iesnervion.avazquez.puntokusapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GameFragment_ViewBinding implements Unbinder {
  private GameFragment target;

  @UiThread
  public GameFragment_ViewBinding(GameFragment target, View source) {
    this.target = target;

    target.evaluateBtn = Utils.findRequiredViewAsType(source, R.id.evaluateBtn, "field 'evaluateBtn'", Button.class);
    target.refreshBtn = Utils.findRequiredViewAsType(source, R.id.refreshBtn, "field 'refreshBtn'", Button.class);
    target.newGameBtn = Utils.findRequiredViewAsType(source, R.id.newGameBtn, "field 'newGameBtn'", Button.class);
    target.layout = Utils.findRequiredViewAsType(source, R.id.layout, "field 'layout'", ConstraintLayout.class);
    target.crono = Utils.findRequiredViewAsType(source, R.id.cronoTime, "field 'crono'", Chronometer.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GameFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.evaluateBtn = null;
    target.refreshBtn = null;
    target.newGameBtn = null;
    target.layout = null;
    target.crono = null;
  }
}
