package jp.yuoku.epoxysampleapp

import com.airbnb.epoxy.EpoxyDataBindingPattern

// Epoxyの設定ファイル
// 頭に"item"とつくレイアウトをEpoxyのモデルと判定して、クラスを自動生成してくれるようになる
@EpoxyDataBindingPattern(rClass = R::class, layoutPrefix = "item")
object SampleEpoxyDataBindingPattern
