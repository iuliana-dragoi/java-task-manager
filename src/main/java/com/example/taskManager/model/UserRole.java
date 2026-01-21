package com.example.taskManager.model;

public enum UserRole {

   ADMIN(true, true),
   USER(false, true),
   GUEST(false, false);

   public final boolean hasWritePermission;
   public final boolean hasReadPermission;

   UserRole(boolean hasWritePermission, boolean hasReadPermission) {
       this.hasWritePermission = hasWritePermission;
       this.hasReadPermission = hasReadPermission;
   }

    public boolean canWrite() {
       return this.hasWritePermission;
    }

    public boolean canRead() {
        return this.hasReadPermission;
    }
}
