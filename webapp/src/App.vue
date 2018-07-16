<template>
  <el-container>
    <el-aside width="12%" height="100%" style="background:#145b7d">
      <img width="100%" height="10%" src="/static/log.png">
      <el-col :span="12">

      <el-menu style="width:600px" :default-active="$route.path" class="el-menu-vertical-demo"  background-color="#145b7d" text-color="#fff" active-text-color="#ffd04b" router>
       <el-submenu index="/">
         <template slot="title">
           <i class="el-icon-location"></i>
           <span>员工</span>
         </template>
         <el-menu-item-group>
           <el-menu-item index="/userManage">员工管理</el-menu-item>
           <el-menu-item index="/award">员工赏罚</el-menu-item>
         </el-menu-item-group>
       </el-submenu>
       <el-submenu index="2">
         <template slot="title">
           <i class="el-icon-menu"></i>
           <span>账单</span>
         </template>
         <el-menu-item-group>
           <el-menu-item index="/account">建材流水</el-menu-item>
           <el-menu-item index="/addAccount">添加账目</el-menu-item>
         </el-menu-item-group>
       </el-submenu>
       <el-submenu index="3">
         <template slot="title">
           <i class="el-icon-menu"></i>
           <span>建材管理</span>
         </template>
         <el-menu-item-group>
           <el-menu-item index="/materials">建材总计</el-menu-item>
          </el-menu-item-group>
       </el-submenu>
       <el-submenu index="4">
         <template slot="title">
           <i class="el-icon-menu"></i>
           <span>客户</span>
         </template>
         <el-menu-item-group>
           <el-menu-item index="/client">客户管理</el-menu-item>
         </el-menu-item-group>
       </el-submenu>
     </el-menu>

   </el-col>
    </el-aside>
    <el-container>
      <el-header height="15%" style="background:#50b7c1">
       </el-header>

      <el-main style="background:#FFFFFF">
          <router-view></router-view>
      </el-main>

    </el-container>
  </el-container>
</template>
<style>
 body > .el-container {
     height:800px;
     margin:0px;
     padding:0px;
    margin-bottom: 0px;
  }
</style>
<script>
export default {
    data() {
      return {

      }
     },
     methods: {

    }
  }
</script>
