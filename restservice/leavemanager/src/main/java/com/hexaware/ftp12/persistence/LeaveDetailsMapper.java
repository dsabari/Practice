package com.hexaware.ftp12.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp12.model.LeaveDetails;
import com.hexaware.ftp12.model.LeaveStatus;
import com.hexaware.ftp12.model.LeaveType;
/**
 * Mapper class to map from result set to leavedetails object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped leavedetails object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final  StatementContext ctx) throws SQLException {
    /**
     * @return LeaveDetails
     */
    return new LeaveDetails(rs.getInt("LEAVE_ID"), LeaveType.valueOf(rs.getString("LEAVE_TYPE")),
      rs.getDate("START_DATE"), rs.getDate("END_DATE"), rs.getInt("NO_OF_DAYS"),
      LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")), rs.getString("LEAVE_REASON"),
      rs.getDate("LEAVE_APPLIED_ON"), rs.getString("MANAGER_COMMENTS"), rs.getInt("EMP_ID"));
  }
}
