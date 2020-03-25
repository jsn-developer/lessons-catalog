package jp.co.solxyz.lessons.catalog.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 商品情報
 * @author HISATO
 *
 */
@Data
public class GoodsEntity implements Serializable{

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 9008599713947157456L;

	/** 固有ID */
	private String id;

	/** 商品名 */
	private String name;

	/** 説明 */
	private String description;

	/** 価格 */
	private long price;

	/** メイン画像のURL */
	private String photo;
}
