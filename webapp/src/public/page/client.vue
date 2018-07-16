<template>
  <el-container>
  <el-header>客户管理：
    <el-form label-width="80px">
      <div style="float:right">
        <el-form-item>
           <el-input v-model="name" placeholder="请输入商家或者联系人" style="width:200px;"></el-input>
           <el-button @click="selectByName">查询</el-button>
        </el-form-item>
      </div>
    </el-form><br/><br/>
    <el-button type="primary" @click="openAdd" >新增</el-button>
  </el-header>

  <el-main>
    <br/>
    <br/>
    <el-table header-align="center" :data="client" border highlight-current-row>
      <el-table-column prop="companyId" label="编号" width="70"/>
      <el-table-column prop="companyName" label="商家名称" width="200"/>
      <el-table-column prop="companyPath" label="商家地址" width="300"/>
      <el-table-column prop="companyContacts" label="联系人" width="100"/>
      <el-table-column prop="companyTel" label="联系电话" width="200"/>
      <el-table-column prop="companyCreateTime" label="修改时间" width="200"/>
       <el-table-column prop="companyPass" label="是否有租借" width="120"/>
      <el-table-column label="操作" width="300" fixed="right">
      <template slot-scope="scope">
        <el-button size="mini" type="primary">查看</el-button>
        <el-button size="mini" @click="update(scope.row)">编辑</el-button>
        <el-button size="mini" type="danger" @click="deleteBox(scope.row)">删除</el-button>
      </template>
    </el-table-column>
    </el-table>
  </el-main>
  <el-footer>
    <div class="block" style="position:absolute;left:50%;bottom:5%;">
        <el-pagination layout="prev, pager, next"  :page-size="page.pageSize" @current-change="pageChange"  :total="page.pageCount"></el-pagination>
    </div>
  </el-footer>

  <el-dialog title="确定要删除该项吗？" :visible.sync="visible" width="20%" :handleClose="handleClose">
    <div style="margin-left:20%">
    <el-button type="danger" @click="delet">确定</el-button>
    <el-button @click="handleClose">取消</el-button>
    </div>
  </el-dialog>

  <el-dialog title="新增或修改" :visible.sync="dialogVisible" width="40%" :before-close="handleClose">
    <el-form label-width="80px">
      <el-form-item>
         <label>商家名称:</label>&emsp;
         <el-input style="width:230px" v-model="insert.companyName" placeholder="请输入商家名称"></el-input>
      </el-form-item>
      <el-form-item>
         <label>商家地址:</label>&emsp;
         <el-input style="width:400px" v-model="insert.companyPath" placeholder="请输入商家地址"></el-input>
      </el-form-item>
      <el-form-item>
         <label>联系人:</label>&emsp;&emsp;
         <el-input style="width:150px" v-model="insert.companyContacts" placeholder="请输入商家联系人姓名"></el-input>
      </el-form-item>
      <el-form-item>
         <label>联系电话:</label>&emsp;
         <el-input style="width:300px" v-model="insert.companyTel" placeholder="请输入联系人电话"></el-input>
      </el-form-item>
      <br/>
      <br/>
      <el-form-item>
        <div style="margin-left:60%">
          <el-button type="primary" @click="submit">确定</el-button>
          <el-button type="danger" @click="handleClose">取消</el-button>
        </div>
      </el-form-item>
    </el-form>
  </el-dialog>
</el-container>
</template>
<script>
export default {
    data() {
      return {
        dialogVisible:false,
        page:{
          pageCount:1,
          pageSize:10,
          pageNum:''
        },
        dialogVisible:false,
        name:'',
        client:[],
        deleteId:'',
        visible: false,
        insert:{
          companyId:'',
          companyName:'',
          companyPath:'',
          companyContacts:'',
          companyTel:'',
          companyPass:'',
          companyCreateTime:''
        }
       }
     },
     methods: {
       openAdd(){
         this.insert = {
           companyId:'',
           companyName:'',
           companyPath:'',
           companyContacts:'',
           companyTel:'',
           companyPass:'',
           companyCreateTime:''
         }
         this.dialogVisible = true
       },
       pageChange(val) {
         this.page.pageNum = val
         console.log(this.page)
       },
       async selectByName() {
           let rep = await this.$ajax.post('/company_basic/select_by_name?name='+this.name,this.page)
           this.client = rep.data.data.list
           this.page={
             pageCount: rep.data.data.total,
             pageSize: rep.data.data.pageSize,
             pageNum: rep.data.data.pageNum
           }
       },
       async pageChange(val) {
         this.page.pageNum = val
         let rep = await this.$ajax.post('/company_basic/select_by_name?name='+this.name,this.page)
         this.client = rep.data.data.list
         this.page={
           pageCount: rep.data.data.total,
           pageSize: rep.data.data.pageSize,
           pageNum: rep.data.data.pageNum
         }
       },
       async update(row) {
          let rep = await this.$ajax.get('/company_basic/select_by_id?id='+row.companyId)
          this.insert = rep.data.data
          this.dialogVisible = true
       },
       async delet() {
          let rep = await this.$ajax.get('/company_basic/company_delete?id='+this.deleteId)
          if(rep.data.code==0) {
            this.$message.success(rep.data.mes);
          } else {
            this.$message.error(rep.data.mes);
          }
          this.name=''
          this.visible = false,
          this.selectByName()
       },
       handleClose(){
         this.deleteId = '',
         this.insert = {
           companyId:'',
           companyName:'',
           companyPath:'',
           companyContacts:'',
           companyTel:'',
           companyPass:'',
           companyCreateTime:''
         }
         this.visible = false,
         this.dialogVisible = false
       },
       async submit(){
         if(this.insert.companyId==''){
           console.log("do insert")
           let rep = await this.$ajax.post("company_basic/company_insert",this.insert)
           if(rep.data.code==0) {
             this.$message.success(rep.data.mes);
             this.name=''
             this.selectByName()
             this.handleClose()
           } else {
             this.$message.error(rep.data.mes);
           }
         }else{
           console.log("do update")
           let rep = await this.$ajax.post("company_basic/update",this.insert)
           if(rep.data.code==0) {
             this.$message.success(rep.data.mes);
             this.name=''
             this.selectByName()
             this.handleClose()
           } else {
             this.$message.error(rep.data.mes);
           }
         }
      },
      deleteBox(row) {
        this.visible = true
        this.deleteId = row.companyId
      }
    },
    async created() {
      let rep = await this.$ajax.post('/company_basic/select_by_name?name='+this.name,this.page)
      this.client = rep.data.data.list
      this.page={
        pageCount: rep.data.data.total,
        pageSize: rep.data.data.pageSize,
        pageNum: rep.data.data.pageNum
      }
    }
  }
</script>
