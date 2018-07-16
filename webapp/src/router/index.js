import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import userManage from '@/public/page/userManage'
import account from '@/public/page/account'
import addAccount from '@/public/page/addAccount'
import award from '@/public/page/award'
import materials from '@/public/page/materials'
import client from '@/public/page/client'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }
    ,{
      path:'/userManage',
      name:'userManage',
      component: userManage
    },{
      path:'/account',
      name:'account',
      component: account
    },{
      path:'/addAccount',
      name:'addAccount',
      component: addAccount
    },{
      path:'/award',
      name:'award',
      component: award
    },{
      path:'/materials',
      name:'materials',
      component: materials
    },{
      path:'/client',
      name:'client',
      component: client
    }
  ]
  })
