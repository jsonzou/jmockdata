package com.github.jsonzou.jmockdata.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelfRefData {

  private String id;
  private String string;
  private Integer Integer;
  private Date date;
  private SelfRefData parent;
  private Map<SelfRefData, SelfRefData> parentMap;
  private SelfRefData[] parentArray;
  private List<SelfRefData> list;
  private List<SelfRefData[]> listArray;
  private List<List<SelfRefData[]>> listListArray;
  private List<SelfRefData>[] arrayList;

  private SelfRefData[][][] data;
  private Map<SelfRefData, SelfRefData[]> mapArray;
  private Map<SelfRefData, List<SelfRefData>> mapList;
  private Map<SelfRefData, List<SelfRefData[]>> mapListArray;

}
