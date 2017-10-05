import java.util.regex.Pattern;

public class SequenceSearchImpl extends SequenceSearch {
	private String newContent;

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
    }

    @Override
    /**
     * "getAllTaggedSequences" returns component of a string enclosed in starting and ending tags.
     */
    public String[] getAllTaggedSequences() {

    	//Finding length of starting and ending tags
    	int startTagLength = super.startTag.length();
    	int endTagLength = super.endTag.length();
    	String line = super.content;
    	String content = super.content;
    	boolean flag=true;
    	/*Finding occurrence of starting and ending tags in a String or
    	 * Finding number of string components enclosed in Tags
    	 */
    	int count1 = line.length() - line.replace(super.startTag, "").length();
    	int count2 = line.length() - line.replace(super.endTag, "").length();
    	if(super.startTag.equalsIgnoreCase(super.endTag))
    		{
    		flag=false;
    		count1 = line.length() - line.replace(super.startTag, "").length();
    		count1=count1/2;
    		}
    	//Initializing result variable array where length = number of occurrence of enclosed tags
    	String result[] = new String[count1/startTagLength];
    	
    	for(int i=0; i<count1/startTagLength; i++) {
    		// Separating enclosed string component between given tags and saving into the result variable
    		if(flag==true) {
    		result[i] = content.substring(content.indexOf(super.startTag)+startTagLength,content.indexOf(super.endTag));
    		
    		// calls method String replacement
    		
    		content = replacement(content.indexOf(super.startTag), content.indexOf(super.endTag), content, startTagLength, endTagLength);
    		

    		}
    		else
    		{
    			int i1 = content.indexOf(super.startTag.toString());
    			content = content.replaceFirst(super.startTag, "");
    			int i2 = content.indexOf(super.endTag);
    			content = content.replaceFirst(super.endTag, "");
    			result[i] = content.substring(i1,i2);     		
    		}
    		
    	}
    	newContent = content;
      return result;
    }
    
    public String replacement(int i, int j, String content, int l1, int l2) {
    	
		String temp,temp2;
		temp = content.substring(content.indexOf(super.startTag),content.indexOf(super.endTag)+l2);
		
		temp2 = content.substring(i+l1,j);
		
		content = content.replace(temp, temp2);

    	return content;
    }
    

    @Override
    /**
     * This method checks for the largest enclosed tag sequence in the given content string
     */
    public String getLongestTaggedSequence() {
    	String[] result = getAllTaggedSequences();
    	int index=0;
    	if(result==null || result.length==0)
    		return null;
    	else
    	{
	    	
	    	if(result.length>1)
	    	{
		    	for(int i=1; i<result.length; i++) {
		    	
		    		if((result[i].length()>=result[index].length()) )
		    		{
		    			index=i;
		    		}
		    		else
		    			index=index;
		    	}
	    	}
	    	}

        return result[index];
    }

    @Override
    /**
     * This method Returns the tagged sequence along with their lengths
     */
    public String displayStringArray() {
    	String result[] = getAllTaggedSequences();
    	int len = result.length;
    	String Present="";
    	
    	for(int i=0; i< len; i++) {
    		int strlen = result[i].length();
    		Present = Present + result[i]+" : " + strlen+"\n";
    	}
       return Present;
    }

    @Override
    public String toString() {
    	String a[] = getAllTaggedSequences();
    	return newContent;
    }

}