// Generated code from Butter Knife. Do not modify!
package es.iesnervion.avazquez.puntokusapp.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import es.iesnervion.avazquez.puntokusapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RankingFragment_ViewBinding implements Unbinder {
  private RankingFragment target;

  @UiThread
  public RankingFragment_ViewBinding(RankingFragment target, View source) {
    this.target = target;

    target.radioGroup = Utils.findRequiredViewAsType(source, R.id.RGfiltrar, "field 'radioGroup'", RadioGroup.class);
    target.listViewRanking = Utils.findRequiredViewAsType(source, R.id.listView_ranking, "field 'listViewRanking'", ListView.class);
    target.animationView = Utils.findRequiredViewAsType(source, R.id.animationLoadRanking, "field 'animationView'", LottieAnimationView.class);
    target.imgErrorLoadingData = Utils.findRequiredViewAsType(source, R.id.imgErrorLoadingData, "field 'imgErrorLoadingData'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RankingFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.radioGroup = null;
    target.listViewRanking = null;
    target.animationView = null;
    target.imgErrorLoadingData = null;
  }
}
