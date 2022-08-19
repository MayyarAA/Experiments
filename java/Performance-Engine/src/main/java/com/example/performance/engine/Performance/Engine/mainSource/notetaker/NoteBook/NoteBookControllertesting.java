package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
@RequestMapping("/api/v1/notebook")
@Component
public class NoteBookControllertesting {

    @GetMapping(value="/test")
    public ResponseEntity<User> getUser(){
//        User user = userService.retrieveUser("Mike");
        main(4);
        return null;
//        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(user);
    }

    public void main(int m){
        FileSharing fileSharing = new FileSharing(m);
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);l1.add(2);
        int id1 = fileSharing.join(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);l2.add(3);
        int id2 = fileSharing.join(l2);
        List<Integer> l3 = new ArrayList<>();
        l2.add(4);
        int id3 = fileSharing.join(l3);
        List<Integer> res1 = fileSharing.request(1,3);
        List<Integer> res2 = fileSharing.request(2,2);
        fileSharing.leave(1);
        List<Integer> res3 = fileSharing.request(2,1);
        fileSharing.leave(2);
        List<Integer> l4 = new ArrayList<>();
        int id4 = fileSharing.join(l4);
    }

    class FileSharing {
        class ChunkOwnerObj{
            int chunkId;
            List<Integer> owners;
            HashMap<Integer,Integer> ownersSet;//<userId,indexInOwners>
            ChunkOwnerObj(int chunkId){
                this.chunkId = chunkId;
                this.owners = new ArrayList<>();
                this.ownersSet = new HashMap<>();
            }
            ChunkOwnerObj(int chunkId, List<Integer> owners){
                this.chunkId = chunkId;
                this.owners = owners;
            }
            void addOwner(int userId){
                int indexOfUserIdInOwners=0;
                int index=0;
                while(index<owners.size() && userId > owners.get(index)){
                    index++;
                }
                if(index<owners.size()){
                    owners.add(index, userId);
                }else{
                    owners.add(userId);
                }
                ownersSet.put(userId, index);
            }
            void removeOwner(int userId){
                int indexInOwners= ownersSet.get(userId);
                owners.remove(indexInOwners);
                ownersSet.remove(userId);
                //add logic to update ownersSet indexes of owners once prev owner si removed
                for(int i=0;i<owners.size();i++){
                    int ownerId = owners.get(i);
                    ownersSet.put(ownerId,i);
                }
            }
        }
        // int[][] chunksOwner;
        ChunkOwnerObj[] chunksOwner;
        HashMap<Integer, HashSet<Integer>> chunksOwnedById = new HashMap<>();
        List<Integer> listOfRecentAvIds = new ArrayList<>();
        int currentHighedId=0;
        public FileSharing(int m) {
            this.chunksOwner = new ChunkOwnerObj[m+1];
        }

        public int join(List<Integer> ownedChunks) {
            int userId = assignId();
            HashSet<Integer> chunksOwnedByUser
                    = chunksOwnedById.getOrDefault(userId, new HashSet<Integer>());
            for(int chunk:ownedChunks){
                chunksOwnedByUser.add(chunk);
                if(chunksOwner[chunk] == null){//double check this logic
                    ChunkOwnerObj chunkOwnerObj = new ChunkOwnerObj(chunk);
//                    chunkOwnerObj.owners.add(userId);//need to add using sortedOrder
                    chunkOwnerObj.addOwner(userId);
                    chunksOwner[chunk] = chunkOwnerObj;
                }else{
                    ChunkOwnerObj chunkOwnerObj = chunksOwner[chunk];
                    // chunkOwnerObj.owners.add(userId);//need to add using sortedOrder
                    chunkOwnerObj.addOwner(userId);
                    chunksOwner[chunk] = chunkOwnerObj;
                }

            }
            chunksOwnedById.put(userId, chunksOwnedByUser);
            return userId;
        }

        public void leave(int userID) {
            addUserIdToListOfRecentAvIds(userID);
            removeIdFromChunksOwnerShip(userID);
        }

        public List<Integer> request(int userID, int chunkID) {
            //add user to this chunk
            ChunkOwnerObj chunksOwnerObj = chunksOwner[chunkID];
            List<Integer> currentOwners = new ArrayList<>(chunksOwnerObj.owners);
            HashSet<Integer> chunksOwnedByUser
                    = chunksOwnedById.get(userID);
            if(chunksOwnedByUser.contains(chunkID)) return  currentOwners;
            chunksOwnerObj.addOwner(userID);
            chunksOwnedByUser.add(chunkID);
            chunksOwnedById.put(userID, chunksOwnedByUser);
            return currentOwners;
        }


        private int assignId(){
            //if listOfAvIds is empty, assign new id
            //need count system to keep track of newCurrentHighestId
            if(listOfRecentAvIds.isEmpty()){
                currentHighedId++;
                return currentHighedId;
            }
            int userId = listOfRecentAvIds.get(0);
            listOfRecentAvIds.remove(0);
            return userId;
        }

        private void removeIdFromChunksOwnerShip(int userId){
            //removes user from all files
            //adds their id to listOfIds
            HashSet<Integer> chunksOwnedByUser = chunksOwnedById.get(userId);
            for(int chunkId: chunksOwnedByUser){
                ChunkOwnerObj chunkOwnerObj = chunksOwner[chunkId];
                // chunkOwnerObj.owners.remove(userId);
                chunkOwnerObj.removeOwner(userId);
                chunksOwner[chunkId] = chunkOwnerObj;
            }
            chunksOwnedById.remove(userId);
        }

        private void assignChunkToId(){
            //<chunkOfMemory>
            //int[List<ids>]
            //<userId,chunks they own>, use that to go into int[] and remove them from there
        }
        private void addUserIdToListOfRecentAvIds(int userId){
            int index=0;
            while(!listOfRecentAvIds.isEmpty() && index<listOfRecentAvIds.size() && userId> listOfRecentAvIds.get(index)){
                index++;
            }
            listOfRecentAvIds.add(index, userId);
        }
    }
/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
 */
}
