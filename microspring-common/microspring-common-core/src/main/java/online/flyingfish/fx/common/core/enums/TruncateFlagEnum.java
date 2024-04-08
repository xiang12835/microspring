/**
 * @Description 文件处理方式
 * @date 2020年05月18日
 * @version V1.0
 * @注意事项 无
 */
package online.flyingfish.fx.common.core.enums;

/**
 * @Description 文件处理方式
 * @date 2020年05月18日
 * @Version V1.0
 * @注意事项 无
 */
public enum TruncateFlagEnum {

	/**先清理表，再插入*/
	Y,
	/**不清理表，直接插入，确保主键不会重复*/
	A,
	/**按照主键更新表，先查询所有主键，命中则更新，不命中则插入 ;
	 * 适用于本地表数据量比较小，增量更新数据比较多的情况;
	 * 注意：要求mapping.xml中必须包含selectAllPrimaryKey语句*/
	U,
	/**按照主键更新表,先删除再插入;
	 * 适用于本地数据量特别大，增量更新数据比较小的情况*/
	D;
	
	public static TruncateFlagEnum byName(String name) {
		for (TruncateFlagEnum flag : TruncateFlagEnum.values()) {
			if (flag.name().equals(name)) {
				return flag;
			}
		}
		throw new RuntimeException("文件处理方式不存在，flag=" + name);
	}
}
