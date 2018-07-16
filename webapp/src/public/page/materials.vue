<template>
  <el-container>
    <el-header>建材管理：
      <el-form label-width="80px">
        <div style="float:right">
          <el-form-item>
             <el-input v-model="selectValue" placeholder="请输入建材名称" style="width:200px;"></el-input>
             <el-button @click="select()">查询</el-button>
          </el-form-item>
        </div>
      </el-form><br/><br/>
      <el-button  type="primary" @click="dialogVisible=true">新增</el-button>
    </el-header>
    <br/>
    <br/>
    <el-main>
      <el-table header-align="center" :data="material" border highlight-current-row>
        <el-table-column prop="matId" label="编号" width="70"/>
        <el-table-column prop="matName" label="名称" width="200"/>
        <el-table-column prop="matCount" label="总数" width="200"/>
        <el-table-column prop="matOut" label="借出数" width="200"/>
        <el-table-column prop="matResidue" label="剩余" width="200"/>
        <el-table-column prop="matUnit" label="单位" width="200"/>
         <el-table-column label="操作" width="300" fixed="right">
        <template slot-scope="scope">
          <el-button size="mini" type="primary">查看</el-button>
          <el-button size="mini" @click="update(scope.row)" >编辑</el-button>
          <el-button size="mini" type="danger">删除</el-button>
        </template>
      </el-table-column>
      </el-table>
    </el-main>

    <el-footer>
      <div class="block" style="position:absolute;left:50%;bottom:5%;">
          <el-pagination layout="prev, pager, next"  :page-size="page.pageSize" @current-change="pageChange"  :total="page.pageCount"></el-pagination>
      </div>
    </el-footer>

<el-dialog title="新增或修改" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
  <el-form label-width="80px">
    <el-form-item>
       <label>建材名称:</label>&emsp;
       <el-input style="width:230px" v-model="matBean.matName" placeholder="请输入建材名称"></el-input>
    </el-form-item>
    <el-form-item>
       <label>已有数量:</label>&emsp;
       <el-input style="width:230px" v-model="matBean.matCount" placeholder="请输入已有数量"></el-input>
    </el-form-item>
    <el-form-item>
       <label>建材单位:</label>&emsp;
       <el-input style="width:230px" v-model="matBean.matUnit" placeholder="请输入建材单位"></el-input>
    </el-form-item>
    <br/>
    <br/>
    <el-form-item>
      <div style="margin-left:60%">
        <el-button type="primary" @click="">确定</el-button>
        <el-button type="danger" @click="clear()">取消</el-button>
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
        page:{
          pageCount:1,
          pageSize:10,
          pageNum:''
        },
        dialogVisible:false,
        selectValue:'',
        material:[],
        matBean:{
          matId:'',
          matName:'',
          matCount:'',
          matOut:'',
          matResidue:'',
          matUnit:''
        }
       }
     },
     methods: {
       clear() {
         this.selectValue = ''
         this.matBean = {
           matId:'',
           matName:'',
           matCount:'',
           matOut:'',
           matResidue:'',
           matUnit:''
         }
         this.dialogVisible = false
       },
       handleClose() {
          this.clear()
       },
       async update(row) {
         let rep = await this.$ajax.get('/material_basic/select_by_id?id='+row.matId)
         this.matBean = rep.data.data
         this.dialogVisible = true
       },
       async pageChange(val) {
         this.page.pageNum = val
         let rep = await this.$ajax.post('/material_basic/select_by_name?name='+this.selectValue,this.page)
         this.material = rep.data.data.list
         this.page={
           pageCount: rep.data.data.total,
           pageSize: rep.data.data.pageSize,
           pageNum: rep.data.data.pageNum
         }
       },
       async select() {
         let rep = await this.$ajax.post('/material_basic/select_by_name?name='+this.selectValue,this.page)
         this.material = rep.data.data.list
         this.page={
           pageCount: rep.data.data.total,
           pageSize: rep.data.data.pageSize,
           pageNum: rep.data.data.pageNum
         }
       },
       async del(row) {
        let rep = await this.$ajax.post('/material_basic/deleteById?id='+row.matId)
        if(rep.data.code==0) {
          this.$message.success(rep.data.mes);
        } else {
          this.$message.error(rep.data.mes);
        }
        this.select()
       }
    },
    async created() {
      let rep = await this.$ajax.post('/material_basic/select_by_name?name='+this.selectValue,this.page)
      this.material = rep.data.data.list
      this.page={
        pageCount: rep.data.data.total,
        pageSize: rep.data.data.pageSize,
        pageNum: rep.data.data.pageNum
      }
    }
  }
</script>
