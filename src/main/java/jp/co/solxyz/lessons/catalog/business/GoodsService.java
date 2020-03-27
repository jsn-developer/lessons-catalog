package jp.co.solxyz.lessons.catalog.business;

import java.util.List;
import java.util.Optional;

import jp.co.solxyz.lessons.catalog.dao.DataDao;
import jp.co.solxyz.lessons.catalog.entity.GoodsEntity;

public class GoodsService {


	/**
	 * 全ての商品情報を取得
	 * @return リスト
	 */
	public List<GoodsEntity> getAllGoods() throws Exception{

		DataDao dao = new DataDao();
		return dao.select("select * from goods");
	}


	/**
	 * IDから商品情報を取得。商品が見つからない場合にはnullを返却
	 * @param id 商品ID
	 * @return 商品情報
	 */
	public Optional<GoodsEntity> getGoodsFromId(String id) throws Exception{

		DataDao dao = new DataDao();

		var ret = dao.select("select * from goods where id = " + id);
		return Optional.of(ret.isEmpty() ? null : ret.get(0));
	}
}
