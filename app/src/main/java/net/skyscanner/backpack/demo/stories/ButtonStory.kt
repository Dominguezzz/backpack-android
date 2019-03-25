package net.skyscanner.backpack.demo.stories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.skyscanner.backpack.button.BpkButton
import net.skyscanner.backpack.chip.BpkChip
import net.skyscanner.backpack.demo.R

class ButtonStory : Story() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_button_primary, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    (0..((view as ViewGroup).childCount - 1)).forEach {
      val child = view.getChildAt(it)
      (child as BpkButton).type = BpkButton.Type.values()[arguments!!.getInt(TYPE)]
    }
  }

  companion object {
    private const val TYPE = "button_type"

    infix fun of(type: BpkButton.Type) = ButtonStory().apply {
      arguments = Bundle()
      arguments?.putInt(LAYOUT_ID, type.ordinal)
    }
  }
}
