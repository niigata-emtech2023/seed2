 /**
  * * model.entity.SpoFesBean.java
 * @author i
 *
 */
package model.entity;

import java.io.Serializable;

/**
 * Beanオブジェクト
 * @author i
 *
 */
public class SpoFesBean implements Serializable{
	/**
	 * 名前
	 */
	private String name;
	
	/**
	 * 得点項目ID
	 */
	private String taskId; 
	
	/**
	 * 得点項目名
	 */
	private String taskName;
	
	/**
	 * 得点
	 */
	private int point;
	
	/**
	 * 順位
	 */
	private int rank;
	
	/**
	 * チーム名
	 */
	private String teamName;
	
	/**
	 * SpoFesBeanの構築
	 */
	public SpoFesBean() {
	}

	/**
	 * フィールドnameの値を返します
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * フィールドnameの値を設定します
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * フィールドtaskIdの値を返します
	 * @return
	 */
	public String getTaskId() {
		return taskId;
	}

	
	/**
	 * フィールドtaskIdの値を設定します
	 * @return
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}


	/**
	 * フィールドtaskNameの値を返します
	 * @return
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * フィールドtaskNameの値を設定します
	 * @return
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * フィールドpointの値を返します
	 * @return
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * フィールドpointの値を設定します
	 * @return
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * フィールドgetRankの値を返します
	 * @return
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * フィールドgetRankの値を設定します
	 * @return
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * フィールドteamNameの値を返します
	 * @return
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * フィールドteamNameの値を設定します
	 * @return
	 */
	public void setTeamName(String teanName) {
		this.teamName = teanName;
	}
	
}