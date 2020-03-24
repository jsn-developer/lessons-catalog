package jp.co.solxyz.lessons.catalog.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jp.co.solxyz.lessons.catalog.entity.GoodsEntity;

public class GoodsService {


	/**
	 * 全ての商品情報を取得
	 * @return リスト
	 */
	public List<GoodsEntity> getAllGoods() {
		List<GoodsEntity> ret = new ArrayList<GoodsEntity>();

		var goods = new GoodsEntity();
		goods.setId("id");
		goods.setName("name");

		ret.add(goods);

		return ret;
	}


	/**
	 * IDから商品情報を取得。商品が見つからない場合にはnullを返却
	 * @param id 商品ID
	 * @return 商品情報
	 */
	public Optional<GoodsEntity> getGoodsFromId(String id) {

		return null;
	}
}
