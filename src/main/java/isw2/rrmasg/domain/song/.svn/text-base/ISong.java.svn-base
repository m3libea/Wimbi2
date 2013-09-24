package isw2.rrmasg.domain.song;

import isw2.rrmasg.domain.Equalable;
import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Inv;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({ "getTitle().equals(\"\")", "getAuthor().equals(\"\")",
		"getRecord().equals(\"\")", "getUrl().equals(\"\")" })
@Inv({ "getUniqueID() != null", "getTitle() != null", "getAuthor() != null",
		"getRecord() != null", "getUrl() != null" })
public interface ISong extends Equalable {

	@Query
	public String getUniqueID();

	@Query
	public String getTitle();

	@Pre("title != null #IllegalArgumentException")
	@Pos({ "getTitle().equals(title)", "getAuthor()@pre.equals(getAuthor())",
			"getRecord()@pre.equals(getRecord())",
			"getUniqueID()@pre.equals(getUniqueID())",
			"getUrl()@pre.equals(getUrl())" })
	public void setTitle(String title) throws IllegalArgumentException;

	@Query
	public String getAuthor();

	@Pre("author != null #IllegalArgumentException")
	@Pos({ "getTitle()@pre.equals(getTitle())", "getAuthor().equals(author)",
			"getRecord()@pre.equals(getRecord())",
			"getUniqueID()@pre.equals(getUniqueID())",
			"getUrl()@pre.equals(getUrl())" })
	public void setAuthor(String author) throws IllegalArgumentException;

	@Query
	public String getRecord();

	@Pre("record != null #IllegalArgumentException")
	@Pos({ "getTitle()@pre.equals(getTitle())",
			"getAuthor()@pre.equals(getAuthor())",
			"getUniqueID()@pre.equals(getUniqueID())",
			"getRecord().equals(record)", "getUrl()@pre.equals(getUrl())" })
	public void setRecord(String record) throws IllegalArgumentException;

	@Query
	public String getUrl();

	@Pre("url != null #IllegalArgumentException")
	@Pos({ "getTitle()@pre.equals(getTitle())",
			"getAuthor()@pre.equals(getAuthor())",
			"getUniqueID()@pre.equals(getUniqueID())",
			"getRecord()@pre.equals(getRecord())", "getUrl().equals(url)" })
	public void setUrl(String url) throws IllegalArgumentException;

}