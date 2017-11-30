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
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import io.caster.customviewgroup.R;

/**
 * Enum used to populate example {@link android.support.v7.widget.RecyclerView.Recycler}.
 */
public enum ListItem {
    ITEM_01(R.id.list_item_01, R.drawable.ic_bubble_chart_black_48dp,
        R.string.list_item_01, R.string.list_item_01_desc),
    ITEM_02(R.id.list_item_02, R.drawable.ic_ac_unit_black_48dp,
        R.string.list_item_02, R.string.list_item_02_desc),
    ITEM_03(R.id.list_item_03, R.drawable.ic_spa_black_48dp,
        R.string.list_item_03, R.string.list_item_03_desc),
    ITEM_04(R.id.list_item_04, R.drawable.ic_whatshot_black_48dp,
        R.string.list_item_04, R.string.list_item_04_desc);

    private static final ListItem[] LIST_ITEMS_ALL = {
        ITEM_01,
        ITEM_02,
        ITEM_03,
        ITEM_04
    };

    //
    // Fields
    //

    public final int resId;
    public final int iconResId;
    public final int stringResId;
    public final int descResId;

    //
    // Constructors
    //

    ListItem(@IdRes int resId, @DrawableRes int iconResId, @StringRes int stringResId, @StringRes int descResId) {
        this.resId = resId;
        this.iconResId = iconResId;
        this.stringResId = stringResId;
        this.descResId = descResId;
    }

    //
    // Example list helpers
    //

    public static int getItemCount() {
        return LIST_ITEMS_ALL.length;
    }

    public static ListItem getItem(int position) {
        return position >= 0 || position < LIST_ITEMS_ALL.length
            ? LIST_ITEMS_ALL[position]
            : ITEM_01;
    }
}
