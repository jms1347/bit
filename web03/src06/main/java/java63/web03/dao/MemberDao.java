package java63.web03.dao;

import java.util.Map;
import java63.web03.domain.Member;

public interface MemberDao {
  Member existUser(Map<String,String> params);
}
