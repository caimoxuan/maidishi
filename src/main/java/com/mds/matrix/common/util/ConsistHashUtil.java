package com.mds.matrix.common.util;

import java.util.*;

/**
 * @author cmx
 * @date 2019/5/8
 */
public final class ConsistHashUtil {

    private static SortedMap<Integer, String> nodesMap = new TreeMap<>();


    private static int getHash(String str) {
        final int p = 16777619;
        int hash = 216613626;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    public static void initNode(List<String> nodes){
        for(String node : nodes){
            nodesMap.put(getHash(node), node);
        }
    }


    public static void intiNodeWithVirtualNodes(List<String> nodes, Integer vNodesCount){
        for(String node : nodes){
            nodesMap.put(getHash(node), node);
            for(int i = 0; i < vNodesCount; i++){
                String vNode = node.concat("&&").concat(String.valueOf(i)).concat("VN");
                nodesMap.put(Math.abs(vNode.hashCode()), vNode);
            }
        }
    }

    public static String getExecuteNode(String value){
        Integer hValue = getHash(value);
        SortedMap<Integer, String> nodes = nodesMap.tailMap(hValue);
        if(nodes.size() == 0){
            return nodesMap.get(nodesMap.firstKey());
        }

        String node = nodes.get(nodes.firstKey());

        return node.substring(0, !node.contains("&&") ? node.length() : node.indexOf("&&"));
    }

    public static void main(String[] args){
        List<String> nodes = new ArrayList<>(Arrays.asList("192.168.0.2:8080", "192.168.0.1:8080", "192.168.0.3:8080"));
        intiNodeWithVirtualNodes(nodes, 150);
        System.out.println(nodesMap);
        String node = getExecuteNode("12htyhntyny,ui,ehgr");
        System.out.println(node);

    }




}
