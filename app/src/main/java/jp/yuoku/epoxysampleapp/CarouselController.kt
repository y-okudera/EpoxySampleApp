package jp.yuoku.epoxysampleapp

import com.airbnb.epoxy.TypedEpoxyController

class CarouselController(
    private val onClickItem: (title: String, description: String) -> Unit
) : TypedEpoxyController<List<CarouselItem>>() { // 使用するクラスが二つとかの場合は、Typed2EpoxyControllerとかを使用する

    override fun buildModels(data: List<CarouselItem>?) {
        data ?: return
        data.forEachIndexed { i, carousel ->
            carousel {
                id(this@CarouselController.modelCountBuiltSoFar)
                carouselItem(carousel)
                onClick { _ ->
                    this@CarouselController.onClickItem.invoke(carousel.title, carousel.description)
                }
            }
        }
    }
}
