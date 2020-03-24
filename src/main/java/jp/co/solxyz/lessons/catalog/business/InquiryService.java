package jp.co.solxyz.lessons.catalog.business;

import java.util.List;

import jp.co.solxyz.lessons.catalog.entity.InquiryEntity;

public class InquiryService {


	/**
	 * 問い合わせ情報の取得
	 * @return
	 */
	public List<InquiryEntity> getInquiries() {
		return getInquiries(null);
	}

	/**
	 * 問い合わせ情報の取得。特定の商品に対する問い合わせ情報を取得可能
	 * @param goodsId 商品ID
	 * @return
	 */
	public List<InquiryEntity> getInquiries(String goodsId) {

		return null;
	}

	/**
	 * 問い合わせ情報の登録
	 * @param entity 登録する問い合わせのEntity情報
	 */
	public void registerInquiry (InquiryEntity entity) {

	}
}
