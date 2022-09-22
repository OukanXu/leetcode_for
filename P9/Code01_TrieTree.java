package P9;

public class Code01_TrieTree{

    //建立前缀树的节点
    public static class TrieNode{
        public int pass;//在加前缀树的时候，该节点通过多少次
        public int end;//这个节点是否为一个字符串的结尾节点，如果是，是多少个字符串的结尾节点
        public TrieNode[] nexts;// HashMap<Char,Node> nexts;

        public TrieNode(){
            pass = 0;
            end = 0;

            //nexts[0] == null  没有走向'a'的路
            //nexts[0] != null  有走向'a'的路
            //nexts[25] != null  有走向'z'的路
            nexts = new TrieNode[26];
        }
    }


    //建立前缀树
    public static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            if(word == null){
                return;
            }

            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for(int i =0; i < chs.length;i++){//从左往右遍历字符
                index = chs[i] - 'a'; // 根据字符，对应成走哪条路
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }


        //查询word这个单词之前加入过几次,查询方法与加入方法相同
        public int search(String word){
            if(word == null){
                return 0;
            }

            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < chs.length; i++){
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;

        }


        //所有加入的字符串中，有几个是以pre字符串为前缀的
        public int prefixNumber(String pre){
            if(pre == null){
                return 0;
            }

            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < chs.length; i++){
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;

        }

        //删除某个字符串
        public void delete(String word){
            if(search(word) != 0){//确定树中确实加入过word，删除
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int index = 0;
                for(int i =0; i < chs.length; i++){
                    index = chs[i] - 'a';
                    node.nexts[index].pass--;
                    if(node.nexts[index].pass == 0){//某个节点p为0了，代表连接到这个节点的所有后续都放弃
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

    }
}