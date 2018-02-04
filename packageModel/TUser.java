package packageModel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author author
*/
public class TUser {


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer id;

    /**
    * 
    * isNullAble:1
    */
    private String user_no;

    /**
    * 
    * isNullAble:1
    */
    private String user_name;

    /**
    * 
    * isNullAble:1
    */
    private String password;

    /**
    * 
    * isNullAble:1
    */
    private String solt;


    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setUser_no(String user_no){
        this.user_no = user_no;
    }

    public String getUser_no(){
        return this.user_no;
    }

    public void setUser_name(String user_name){
        this.user_name = user_name;
    }

    public String getUser_name(){
        return this.user_name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setSolt(String solt){
        this.solt = solt;
    }

    public String getSolt(){
        return this.solt;
    }
    @Override
    public String toString() {
        return "TUser{" +
                "id='" + id + '\'' +
                "user_no='" + user_no + '\'' +
                "user_name='" + user_name + '\'' +
                "password='" + password + '\'' +
                "solt='" + solt + '\'' +
            '}';
    }

    public static QueryBuilder QueryBuild(){
        return new QueryBuilder();
    }

    public static class QueryBuilder extends TUser{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){
            return this.fetchFields;
        }

        private List<Integer> idList;


        private List<String> user_noList;


        private List<String> fuzzyUser_no;

        public List<String> getFuzzyUser_no(){
            return this.fuzzyUser_no;
        }

        private List<String> rightFuzzyUser_no;

        public List<String> getRightFuzzyUser_no(){
            return this.rightFuzzyUser_no;
        }
        private List<String> user_nameList;


        private List<String> fuzzyUser_name;

        public List<String> getFuzzyUser_name(){
            return this.fuzzyUser_name;
        }

        private List<String> rightFuzzyUser_name;

        public List<String> getRightFuzzyUser_name(){
            return this.rightFuzzyUser_name;
        }
        private List<String> passwordList;


        private List<String> fuzzyPassword;

        public List<String> getFuzzyPassword(){
            return this.fuzzyPassword;
        }

        private List<String> rightFuzzyPassword;

        public List<String> getRightFuzzyPassword(){
            return this.rightFuzzyPassword;
        }
        private List<String> soltList;


        private List<String> fuzzySolt;

        public List<String> getFuzzySolt(){
            return this.fuzzySolt;
        }

        private List<String> rightFuzzySolt;

        public List<String> getRightFuzzySolt(){
            return this.rightFuzzySolt;
        }
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }



        public QueryBuilder id(Integer id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Integer ... id){
            this.idList = Arrays.asList(id);
            return this;
        }

        public QueryBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }



        public QueryBuilder fuzzyUser_no (List<String> fuzzyUser_no){
            this.fuzzyUser_no = fuzzyUser_no;
            return this;
        }

        public QueryBuilder fuzzyUser_no (String ... fuzzyUser_no){
            this.fuzzyUser_no = Arrays.asList(fuzzyUser_no);
            return this;
        }

        public QueryBuilder rightFuzzyUser_no (List<String> rightFuzzyUser_no){
            this.rightFuzzyUser_no = rightFuzzyUser_no;
            return this;
        }

        public QueryBuilder rightFuzzyUser_no (String ... rightFuzzyUser_no){
            this.rightFuzzyUser_no = Arrays.asList(rightFuzzyUser_no);
            return this;
        }

        public QueryBuilder user_no(String user_no){
            setUser_no(user_no);
            return this;
        }

        public QueryBuilder user_noList(String ... user_no){
            this.user_noList = Arrays.asList(user_no);
            return this;
        }

        public QueryBuilder user_noList(List<String> user_no){
            this.user_noList = user_no;
            return this;
        }

        public QueryBuilder fetchUser_no(){
            setFetchFields("fetchFields","user_no");
            return this;
        }

        public QueryBuilder excludeUser_no(){
            setFetchFields("excludeFields","user_no");
            return this;
        }



        public QueryBuilder fuzzyUser_name (List<String> fuzzyUser_name){
            this.fuzzyUser_name = fuzzyUser_name;
            return this;
        }

        public QueryBuilder fuzzyUser_name (String ... fuzzyUser_name){
            this.fuzzyUser_name = Arrays.asList(fuzzyUser_name);
            return this;
        }

        public QueryBuilder rightFuzzyUser_name (List<String> rightFuzzyUser_name){
            this.rightFuzzyUser_name = rightFuzzyUser_name;
            return this;
        }

        public QueryBuilder rightFuzzyUser_name (String ... rightFuzzyUser_name){
            this.rightFuzzyUser_name = Arrays.asList(rightFuzzyUser_name);
            return this;
        }

        public QueryBuilder user_name(String user_name){
            setUser_name(user_name);
            return this;
        }

        public QueryBuilder user_nameList(String ... user_name){
            this.user_nameList = Arrays.asList(user_name);
            return this;
        }

        public QueryBuilder user_nameList(List<String> user_name){
            this.user_nameList = user_name;
            return this;
        }

        public QueryBuilder fetchUser_name(){
            setFetchFields("fetchFields","user_name");
            return this;
        }

        public QueryBuilder excludeUser_name(){
            setFetchFields("excludeFields","user_name");
            return this;
        }



        public QueryBuilder fuzzyPassword (List<String> fuzzyPassword){
            this.fuzzyPassword = fuzzyPassword;
            return this;
        }

        public QueryBuilder fuzzyPassword (String ... fuzzyPassword){
            this.fuzzyPassword = Arrays.asList(fuzzyPassword);
            return this;
        }

        public QueryBuilder rightFuzzyPassword (List<String> rightFuzzyPassword){
            this.rightFuzzyPassword = rightFuzzyPassword;
            return this;
        }

        public QueryBuilder rightFuzzyPassword (String ... rightFuzzyPassword){
            this.rightFuzzyPassword = Arrays.asList(rightFuzzyPassword);
            return this;
        }

        public QueryBuilder password(String password){
            setPassword(password);
            return this;
        }

        public QueryBuilder passwordList(String ... password){
            this.passwordList = Arrays.asList(password);
            return this;
        }

        public QueryBuilder passwordList(List<String> password){
            this.passwordList = password;
            return this;
        }

        public QueryBuilder fetchPassword(){
            setFetchFields("fetchFields","password");
            return this;
        }

        public QueryBuilder excludePassword(){
            setFetchFields("excludeFields","password");
            return this;
        }



        public QueryBuilder fuzzySolt (List<String> fuzzySolt){
            this.fuzzySolt = fuzzySolt;
            return this;
        }

        public QueryBuilder fuzzySolt (String ... fuzzySolt){
            this.fuzzySolt = Arrays.asList(fuzzySolt);
            return this;
        }

        public QueryBuilder rightFuzzySolt (List<String> rightFuzzySolt){
            this.rightFuzzySolt = rightFuzzySolt;
            return this;
        }

        public QueryBuilder rightFuzzySolt (String ... rightFuzzySolt){
            this.rightFuzzySolt = Arrays.asList(rightFuzzySolt);
            return this;
        }

        public QueryBuilder solt(String solt){
            setSolt(solt);
            return this;
        }

        public QueryBuilder soltList(String ... solt){
            this.soltList = Arrays.asList(solt);
            return this;
        }

        public QueryBuilder soltList(List<String> solt){
            this.soltList = solt;
            return this;
        }

        public QueryBuilder fetchSolt(){
            setFetchFields("fetchFields","solt");
            return this;
        }

        public QueryBuilder excludeSolt(){
            setFetchFields("excludeFields","solt");
            return this;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            this.fetchFields.put("otherFields",Arrays.asList(fields));
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.getOrDefault(key,new HashMap<>());
            fields.put(val,true);
            this.fetchFields.putIfAbsent(key,fields);
        }

        public TUser build(){
            return this;
        }
    }

}
