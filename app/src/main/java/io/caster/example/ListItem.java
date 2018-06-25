/*
 * Copyright (C) 2015 Randomly Typing LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.caster.example;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import io.caster.customviewgroup.R;

/**
 * Enum used to populate example {@link android.support.v7.widget.RecyclerView.Recycler}.
 */
public enum ListItem {
    ITEM_01(R.drawable.ic_bubble_chart_black_48dp, R.string.list_item_01, R.string.list_item_01_desc),
    ITEM_02(R.drawable.ic_ac_unit_black_48dp, R.string.list_item_02, R.string.list_item_02_desc),
    ITEM_03(R.drawable.ic_spa_black_48dp, R.string.list_item_03, R.string.list_item_03_desc),
    ITEM_04(R.drawable.ic_whatshot_black_48dp, R.string.list_item_04, R.string.list_item_04_desc);

    public final int iconResId;
    public final int titleResId;
    public final int descResId;

    ListItem(@DrawableRes int iconResId, @StringRes int titleResId, @StringRes int descResId) {
        this.iconResId = iconResId;
        this.titleResId = titleResId;
        this.descResId = descResId;
    }
}
